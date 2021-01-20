package com.gifgroen.state

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "com.gifgroen.state.AppSettingsState",
    storages = [
        Storage("SdkSettingsPlugin.xml")
    ]
)
class AppSettingsState : PersistentStateComponent<AppSettingsState> {

    companion object {
        fun getInstance(): AppSettingsState? {
            return ServiceManager.getService(AppSettingsState::class.java)
        }
    }

    var userId: String? = "John Q. Public"

    var ideaStatus: Boolean? = false

    override fun getState(): AppSettingsState {
        return this
    }

    override fun loadState(state: AppSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}