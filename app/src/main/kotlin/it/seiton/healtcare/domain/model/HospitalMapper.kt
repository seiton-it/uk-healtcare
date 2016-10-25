package it.seiton.healtcare.domain.model

import android.content.ContentValues
import android.database.Cursor
import it.seiton.healtcare.infrastructure.api.model.HospitalJsonModel
import it.seiton.library.domain.model.EntityMapper

/**
 * Created by lukasw44 on 18/10/2016.
 */
class HospitalMapper : EntityMapper<HospitalJsonModel, HospitalEntity> {


    override fun mapToEntity(json: HospitalJsonModel): HospitalEntity {

        val builder: StringBuilder = StringBuilder()
        if (!json.address1.isNullOrEmpty()) {
            builder.append(json.address1).append(" ")
        }

        if (!json.address2.isNullOrEmpty()) {
            builder.append(json.address2).append(" ")
        }
        if (!json.address3.isNullOrEmpty()) {
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
                if (json.city.isNullOrEmpty()) " " else json.city.toLowerCase(),
                if (json.city.isNullOrEmpty()) " " else json.city.substring(0, 1).toUpperCase(),
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