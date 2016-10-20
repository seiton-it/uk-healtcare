package it.seiton.healtcare.infrastructure.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by lukasw44 on 18/10/2016.
 */
class HospitalJsonModel(
        @SerializedName("organisation_id")
        val organisationId: Int,
        val website: String,
        @SerializedName("sub_type")
        val subType: String,
        val sector: String,
        val postcode: String,
        val phone: String,
        @SerializedName("partial_postcode")
        val partialPostcode: String,
        @SerializedName("parent_o_d_s_code")
        val parentOdsCode: String,
        @SerializedName("parent_name")
        val parentName: String,
        @SerializedName("organisation_type")
        val organisationType: String,
        @SerializedName("organisation_status")
        val organisationStatus: String,
        @SerializedName("organisation_name")
        val organisationName: String,
        @SerializedName("organisation_code")
        val organisationCode: String,
        val latitude: Double,
        val longitude: Double,
        @SerializedName("is_pims_managed")
        val isPimsManaged: Boolean,
        val fax: String,
        val email: String,
        val county: String,
        val city: String,
        val address1: String,
        val address2: String,
        val address3: String) {

    override fun toString(): String {
        return "HospitalJsonModel(organisationId=$organisationId, website='$website', subType='$subType', sector='$sector', postcode='$postcode', phone='$phone', partialPostcode='$partialPostcode', parentOdsCode='$parentOdsCode', parentName='$parentName', organisationType='$organisationType', organisationStatus='$organisationStatus', organisationName='$organisationName', organisationCode='$organisationCode', latitude=$latitude, longitude=$longitude, isPimsManaged=$isPimsManaged, fax='$fax', email='$email', county='$county', city='$city', address1='$address1', address2='$address2', address3='$address3')"
    }
}