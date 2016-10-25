package it.seiton.healtcare.domain.model

import android.text.TextUtils
import it.seiton.library.domain.model.BaseEntity

/**
 * Created by lukasw44 on 18/10/2016.
 */
class HospitalEntity(id: Int, val website: String,
                     val subType: String,
                     val sector: String,
                     val postcode: String,
                     val phone: String,
                     val partialPostcode: String,
                     val parentOdsCode: String,
                     val parentName: String,
                     val organisationType: String,
                     val organisationStatus: String,
                     val organisationName: String,
                     val organisationNameLowercase: String,
                     val organisationFirstChar: String,
                     val organisationCode: String,
                     val latitude: Double,
                     val latRadSin: Double,
                     val latRadCos: Double,
                     val longitude: Double,
                     val lonRadSin: Double,
                     val lonRadCos: Double,
                     val pimsManaged: Boolean,
                     val fax: String,
                     val email: String,
                     val county: String,
                     val city: String,
                     val cityLowercaser: String,
                     val cityFirstChar: String,
                     val fullAddress: String,
                     val address1: String,
                     val address2: String,
                     val address3: String) : BaseEntity(id), HospitalModel {

    val cityAndCounty: String

    init {
        if(!city.isNullOrEmpty()){

            if(county.isNullOrEmpty()){
                cityAndCounty = city
            }else{
                cityAndCounty = city + ", " + county.toUpperCase()
            }
        }else if(!county.isNullOrEmpty()){
            cityAndCounty = county.toUpperCase()
        }else{
            cityAndCounty = "-----"
        }

    }

    override fun website(): String = website

    override fun subType(): String = subType

    override fun sector(): String = sector

    override fun postcode(): String = postcode

    override fun phone(): String = phone

    override fun partialPostcode(): String = partialPostcode

    override fun parentOdsCode(): String = parentOdsCode

    override fun parentName(): String = parentName

    override fun organisationType(): String = organisationType

    override fun organisationStatus(): String = organisationStatus

    override fun organisationName(): String = organisationName

    override fun organisationNameLowercase(): String = organisationNameLowercase

    override fun organisationFirstChar(): String = organisationFirstChar

    override fun organisationCode(): String = organisationCode

    override fun latitude(): Double = latitude

    override fun latRadSin(): Double = latRadSin

    override fun latRadCos(): Double = latRadCos

    override fun longitude(): Double = longitude

    override fun lonRadSin(): Double = lonRadSin

    override fun lonRadCos(): Double = lonRadCos

    override fun pimsManaged(): Boolean = pimsManaged

    override fun fax(): String = fax

    override fun email(): String = email

    override fun county(): String = county

    override fun city(): String = city

    override fun cityLowercase(): String = cityLowercaser

    override fun cityFirstChar(): String = cityFirstChar

    override fun fullAddress(): String = fullAddress

    override fun address1(): String = address1

    override fun address2(): String = address2

    override fun address3(): String = address3

    override fun toString(): String {
        return "HospitalEntity(id='${id()}'website='$website', subType='$subType', sector='$sector', postcode='$postcode', phone='$phone', partialPostcode='$partialPostcode', parentOdsCode='$parentOdsCode', parentName='$parentName', organisationType='$organisationType', organisationStatus='$organisationStatus', organisationName='$organisationName', organisationNameLowercase='$organisationNameLowercase', organisationFirstChar='$organisationFirstChar', organisationCode='$organisationCode', latitude=$latitude, latRadSin=$latRadSin, latRadCos=$latRadCos, longitude=$longitude, lonRadSin=$lonRadSin, lonRadCos=$lonRadCos, pimsManaged=$pimsManaged, fax='$fax', email='$email', county='$county', city='$city', cityLowercaser='$cityLowercaser', cityFirstChar='$cityFirstChar', fullAddress='$fullAddress', address1='$address1', address2='$address2', address3='$address3')"
    }

    companion object Factory {

        val FACTORY: HospitalModel.Factory<HospitalEntity>// lambda not working here kotlin error ...
            get() = HospitalModel.Factory(object : HospitalModel.Creator<HospitalEntity> {
                override fun create(id: Int, website: String, subType: String, sector: String, postcode: String, phone: String, partialPostcode: String, parentOdsCode: String, parentName: String, organisationType: String, organisationStatus: String, organisationName: String, organisationNameLowercase: String, organisationFirstChar: String, organisationCode: String, latitude: Double, latRadSin: Double, latRadCos: Double, longitude: Double, lonRadSin: Double, lonRadCos: Double, pimsManaged: Boolean, fax: String, email: String, county: String, city: String, cityLowercase: String, cityFirstChar: String, fullAddress: String, address1: String, address2: String, address3: String): HospitalEntity
                        = HospitalEntity(id, website, subType, sector, postcode, phone, partialPostcode, parentOdsCode, parentName, organisationType, organisationStatus, organisationName, organisationNameLowercase, organisationFirstChar, organisationCode, latitude, latRadSin, latRadCos, longitude, lonRadSin, lonRadCos, pimsManaged, fax, email, county, city, cityLowercase, cityFirstChar, fullAddress, address1, address2, address3)
            })

        val MAPPER = FACTORY.select_by_idMapper()
    }


}
