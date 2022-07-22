package com.hexagonal.infra.databasestatic.converter

import com.hexagonal.domain.model.User
import com.hexagonal.domain.model.Vaccine
import com.hexagonal.domain.model.VaccineApplication
import com.hexagonal.infra.databasestatic.adapter.DataBaseRepository.Companion.getVaccineApplicationEntityId
import com.hexagonal.infra.databasestatic.entity.UserEntity
import com.hexagonal.infra.databasestatic.entity.VaccineApplicationEntity
import com.hexagonal.infra.databasestatic.entity.VaccineEntity

class DataBaseMapper {
    companion object {
        fun toVaccineApplicationEntity(
            vaccineApplication: VaccineApplication
        ): VaccineApplicationEntity {
            with(vaccineApplication) {
                return VaccineApplicationEntity(
                    id = getVaccineApplicationEntityId().toString(),
                    vaccine = toVaccineEntity(vaccine),
                    user = toUserEntity(user)
                )
            }
        }

        fun toVaccineApplication(
            vaccineApplicationEntity: VaccineApplicationEntity
        ): VaccineApplication {
            with(vaccineApplicationEntity) {
                return VaccineApplication(
                    id = id,
                    vaccine = toVaccine(vaccine),
                    user = toUser(user)
                )
            }
        }

        fun toVaccine(
            vaccineEntity: VaccineEntity
        ): Vaccine {
            return Vaccine(
                vaccineEntity.name
            )
        }

        fun toVaccineEntity(
            vaccine: Vaccine
        ): VaccineEntity {
            return VaccineEntity(
                vaccine.name
            )
        }

        fun toUser(
            userEntity: UserEntity
        ): User {
            return User(
                name = userEntity.name,
                email = userEntity.email
            )
        }

        fun toUserEntity(
            user: User
        ): UserEntity {
            return UserEntity(
                name = user.name,
                email = user.email
            )
        }
    }
}