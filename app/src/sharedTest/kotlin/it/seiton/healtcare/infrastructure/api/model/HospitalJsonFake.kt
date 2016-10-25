package it.seiton.healtcare.infrastructure.api.model

import it.seiton.healtcare.infrastructure.api.model.HospitalJsonModel

/**
 * Created by lukasw44 on 24/10/2016.
 */
object HospitalJsonFake {

    fun getHospitalJson(city: String = "", county: String = ""): HospitalJsonModel {
        return HospitalJsonModel(
                organisationId = 1,
                website = "test.localhost.com",
                subType = "Hospital",
                sector = "NHS",
                postcode = "GU12",
                phone = "123123",
                partialPostcode = "GU",
                parentOdsCode = "NDA",
                parentName = "Nuffield Health",
                organisationType = "Hospital",
                organisationStatus = "visible",
                organisationName = "Fowey Hospital",
                organisationCode = "RV9US",
                latitude = 53.85313415527344,
                longitude = -0.4114723205566406,
                isPimsManaged = true,
                fax = "987654",
                email = "hospital@localhost.com",
                county = county,
                city = city,
                address1 = "Swinemour",
                address2 = "Lane",
                address3 = "Woodington"
        )
    }
}