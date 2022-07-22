package com.hexagonal.infra.databasestatic.adapter

import com.hexagonal.domain.model.VaccineApplication
import com.hexagonal.domain.port.Repository
import com.hexagonal.infra.databasestatic.converter.DataBaseMapper
import com.hexagonal.infra.databasestatic.entity.UserEntity
import com.hexagonal.infra.databasestatic.entity.VaccineApplicationEntity
import com.hexagonal.infra.databasestatic.entity.VaccineEntity

class DataBaseRepository : Repository {

    companion object {
        val users = mutableListOf<UserEntity>()
        val vaccines = mutableListOf<VaccineEntity>()
        val vaccineApplications = mutableListOf<VaccineApplicationEntity>()
        private var vaccineApplicationEntityId = 0
        fun getVaccineApplicationEntityId() = ++vaccineApplicationEntityId
    }

    override fun existsUser(email: String): Boolean {
        users.forEach { userEntity ->
            if (userEntity.email == email) {
                return true
            }
        }
        return false
    }

    override fun existsVaccine(name: String): Boolean {
        vaccines.forEach { userEntity ->
            if (userEntity.name == name) {
                return true
            }
        }
        return false
    }

    override fun save(
        vaccineApplication: VaccineApplication
    ): VaccineApplication {
        val entity = DataBaseMapper.toVaccineApplicationEntity(
            vaccineApplication = vaccineApplication
        )
        vaccineApplications.add(entity)
        return DataBaseMapper.toVaccineApplication(entity)
    }
}