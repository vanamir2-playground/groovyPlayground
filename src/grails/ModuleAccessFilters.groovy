package grails

import eu.abra.primaerp.api.beans.core.License
import eu.abra.primaerp.api.beans.core.Product
import eu.abra.primaerp.core.AccessesService
import eu.abra.primaerp.core.LicensesService
import eu.abra.primaerp.utils.SessionService

class ModuleAccessFilters {

    // https://grails.github.io/grails2-doc/2.4.3/guide/single.html#filterDependencies
    // predtim nez se provede tento filtr se musi provest SecurityFilters
    // tzn. se tim definuje zavislost
    def dependsOn = [SecurityFilters]

    // importovane service
    AccessesService accessesService
    SessionService sessionService
    LicensesService licensesService

    // Grails filtery https://grails.github.io/grails2-doc/2.4.3/guide/single.html#filters
    // obsahuje metody
    // - jejich nazev je nazev filtru
    // - parametry vymezují rozsah platnosti filteru
    def filters = {
        /**
         * Saves all modules that user can access into session variable. Concretely sets: session.moduleAccess
         */

        // vsechny kontrolery, kromě *Gapi|errors|login|auth|sso
        // vsechny akce
        setAllModuleAccesses(controller: '*', action: '*', controllerExclude: "*Gapi|errors|login|auth|sso") {
            // typ filteru
            // before = filter se vyhodnotí před akcí. pokud vrátí false, neprovádí se ani ostatní filtery
            before = {
                if (session.moduleAccess == null && session.user != null) {

                    session.moduleAccess = accessesService.getUsersModules(session.user.id)

                    def allProducts = Product.values.findAll { it != Product.CORE }
                    def validLicenses = licensesService.readAllValid()

                    // map with all products and boolean flag for current user
                    session.userAccesses = allProducts.collectEntries { Product product ->
                        [product.toString(), session.moduleAccess.contains(product.toString())]
                    }

                    // map of all products with sum of users count
                    session.companyLicenses = allProducts.collectEntries { Product product ->
                        [product.toString(), 0]
                    } + validLicenses.groupBy { License license ->
                        license.product
                    }.collectEntries { Product product, List<License> licenses ->
                        [product.toString(), licenses.sum { it.usersCount }]
                    }

                    // set of valid promo codes
                    session.companyPromoCodes = validLicenses.collect { it.promoCode }.findAll { it }.unique().sort().join(", ")
                }

                // don't forget to return true
                return true
            }

        }
    }
}

