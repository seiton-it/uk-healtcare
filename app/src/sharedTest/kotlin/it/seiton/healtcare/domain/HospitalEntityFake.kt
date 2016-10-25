package it.seiton.healtcare.domain

import it.seiton.healtcare.domain.model.HospitalEntity

/**
 * Created by lukasw44 on 24/10/2016.
 */
object HospitalEntityFake {

    fun getSimpleEntity(id: Int = 1,
                        organisationName: String = "",
                        postcode: String = "",
                        phone: String = "",
                        fax: String = "",
                        website: String = "",
                        email: String = "",
                        county: String = "",
                        city: String = "",
                        fullAddress: String = "",
                        sector: String = ""
    ): HospitalEntity {
        return HospitalEntity(
                id = id,
                website = website,
                subType = "Hospital",
                sector = sector,
                postcode = postcode,
                phone = "",
                partialPostcode = "",
                parentOdsCode = "",
                parentName = "",
                organisationType = "Hospital",
                organisationStatus = "visible",
                organisationName = organisationName,
                organisationNameLowercase = "",
                organisationFirstChar = "",
                organisationCode = "",
                latitude = 0.0,
                latRadSin = 0.0,
                latRadCos = 0.0,
                longitude = 0.0,
                lonRadSin = 0.0,
                lonRadCos = 0.0,
                pimsManaged = true,
                fax = "",
                email = email,
                county = county,
                city = city,
                cityLowercaser = "",
                cityFirstChar = "",
                fullAddress = fullAddress,
                address1 = "",
                address2 = "",
                address3 = ""
        )
    }

    fun getWithCityAndCounty(city: String = "", county: String = ""): HospitalEntity {
        return getSimpleEntity(city = city, county = county)
    }

}