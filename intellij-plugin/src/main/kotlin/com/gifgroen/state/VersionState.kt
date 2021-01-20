package com.gifgroen.state

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "com.gifgroen.state.VersionState",
    storages = [
        Storage("version.xml")
    ]
)
class VersionState(
    var currentVersion: String = "0.0"
) : PersistentStateComponent<VersionState> {

    companion object {
        fun getInstance(): VersionState {
            return ServiceManager.getService(VersionState::class.java)
        }
    }

    override fun getState(): VersionState {
        return this
    }

    override fun loadState(state: VersionState) {
        return XmlSerializerUtil.copyBean(state, this)
    }

    fun isNewVersion(newVersion: String): Boolean {
        val s1 = semVerToNumbers(currentVersion)
        val s2 = semVerToNumbers(newVersion)
        return s1.zip(s2).any {
            it.first < it.second
        }
    }

    private fun semVerToNumbers(versionString: String): List<Int> {
        return versionString.split("-").first().split(".").map { it.toInt() }
    }
}