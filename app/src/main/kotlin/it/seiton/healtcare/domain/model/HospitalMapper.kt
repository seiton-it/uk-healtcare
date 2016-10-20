package it.seiton.healtcare.domain.model

import android.content.ContentValues
import android.database.Cursor
import android.text.TextUtils
import it.seiton.library.domain.model.EntityMapper
import it.seiton.healtcare.infrastructure.api.model.HospitalJsonModel

/**
 * Created by lukasw44 on 18/10/2016.
 */
class HospitalMapper : EntityMapper<HospitalJsonModel, HospitalEntity> {


    override fun mapToEntity(json: HospitalJsonModel): HospitalEntity {

        val builder: StringBuilder = StringBuilder()
        if (!TextUtils.isEmpty(json.address1)) {
            builder.append(json.address1).append(" ")
        }

        if (!TextUtils.isEmpty(json.address2)) {
            builder.append(json.address2).append(" ")
        }
        if (!TextUtils.isEmpty(json.address3)) {
            builder.append(json.address3)
        }

        val fullAddress = builder.trim().toString()

        return HospitalEntity(
                json.organisationId,
                json.website,
                json.subType,
                json.sector,
                json.postcode,
                json.phone,
                json.partialPostcode,
                json.parentOdsCode,
                json.parentName,
                json.organisationType,
                json.organisationStatus,
                json.organisationName,
                json.organisationName.toLowerCase(),
                json.organisationName.substring(0, 1).toUpperCase(),
                json.organisationCode,
                json.latitude,
                Math.sin(json.latitude * DEGREE_TO_RADIAN),
                Math.cos(json.latitude * DEGREE_TO_RADIAN),
                json.longitude,
                Math.sin(json.longitude * DEGREE_TO_RADIAN),
                Math.cos(json.longitude * DEGREE_TO_RADIAN),
                json.isPimsManaged,
                json.fax,
                json.email,
                json.county,
                json.city,
                if (TextUtils.isEmpty(json.city)) " " else json.city.toLowerCase(),
                if (TextUtils.isEmpty(json.city)) " " else json.city.substring(0, 1).toUpperCase(),
                fullAddress,
                json.address1,
                json.address2,
                json.address3
        )
    }

    override fun mapToEntity(cursor: Cursor): HospitalEntity {
        return HospitalEntity.MAPPER.map(cursor)
    }

    override fun mapToContentValues(entity: HospitalEntity): ContentValues {
        return HospitalEntity.FACTORY.marshal(entity).asContentValues()
    }

    companion object {
        const val DEGREE_TO_RADIAN: Double = 0.0174532925
    }
}