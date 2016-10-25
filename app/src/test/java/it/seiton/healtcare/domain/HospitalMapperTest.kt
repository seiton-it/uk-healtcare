package it.seiton.healtcare.domain

import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.healtcare.domain.model.HospitalMapper
import it.seiton.healtcare.infrastructure.api.model.HospitalJsonFake
import it.seiton.healtcare.infrastructure.api.model.HospitalJsonModel
import org.junit.Test

/**
 * Created by lukasw44 on 24/10/2016.
 */
class HospitalMapperTest {

    val fixture: HospitalMapper = HospitalMapper()

    @Test
    fun mapToEntity_HospitalJsonModel_shouldMapToEntity() {

        //given
        val json = HospitalJsonModel(
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
                county = "Surrey",
                city = "Farnham",
                address1 = "Swinemour",
                address2 = "Lane",
                address3 = "Woodington"
        )

        //when
        val entity: HospitalEntity = fixture.mapToEntity(json)

        //then
        assert(entity.id == 1)
        assert(entity.website == "test.localhost.com")
        assert(entity.subType == "Hospital")
        assert(entity.sector == "NHS")
        assert(entity.postcode == "GU12")
        assert(entity.phone == "123123")
        assert(entity.partialPostcode == "GU")
        assert(entity.parentOdsCode == "NDA")
        assert(entity.organisationType == "Hospital")
        assert(entity.organisationStatus == "visible")
        assert(entity.organisationName == "Fowey Hospital")
        assert(entity.organisationNameLowercase == "fowey hospital")
        assert(entity.organisationFirstChar == "F")
        assert(entity.organisationCode == "RV9US")
        assert(entity.latitude == 53.85313415527344)
        assert(entity.latRadSin == 0.8075076720246583)
        assert(entity.latRadCos == 0.5898570671114459)
        assert(entity.longitude == -0.4114723205566406)
        assert(entity.lonRadSin == -0.007181485035570983)
        assert(entity.lonRadCos == 0.9999742128038522)
        assert(entity.pimsManaged == true)
        assert(entity.fax == "987654")
        assert(entity.email == "hospital@localhost.com")
        assert(entity.county == "Surrey")
        assert(entity.city == "Farnham")
        assert(entity.cityLowercaser == "farnham")
        assert(entity.cityFirstChar == "F")
        assert(entity.address1 == "Swinemour")
        assert(entity.address2 == "Lane")
        assert(entity.address3 == "Woodington")
        assert(entity.fullAddress == "Swinemour Lane Woodington")
        assert(entity.cityAndCounty == "Farnham, SURREY")
    }

    @Test
    fun mapToEntity_CityPresentCountyEmpty_MapOnlyCity() {

        //given
        val json = HospitalJsonFake.getHospitalJson(city = "Farnham")

        //when
        val entity: HospitalEntity = fixture.mapToEntity(json)

        //then
        assert(entity.cityAndCounty == "Farnham")

    }

    @Test
    fun mapToEntity_CityEmptyCountyPresent_MapOnlyCity() {

        //given
        val json = HospitalJsonFake.getHospitalJson(county = "Surrey")

        //when
        val entity: HospitalEntity = fixture.mapToEntity(json)

        //then
        assert(entity.cityAndCounty == "SURREY")
    }

    @Test
    fun mapToEntity_CityEmptyCountyEmpty_MapOnlyCity() {

        //given
        val json = HospitalJsonFake.getHospitalJson(city = "", county = "")

        //when
        val entity: HospitalEntity = fixture.mapToEntity(json)

        //then
        assert(entity.cityAndCounty == "-----")
    }
}