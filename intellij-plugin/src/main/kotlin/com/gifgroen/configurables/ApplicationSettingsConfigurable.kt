package com.gifgroen.configurables

import com.gifgroen.components.ApplicationSettingsComponent
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent
import com.gifgroen.state.AppSettingsState
import org.jetbrains.annotations.Nls


class ApplicationSettingsConfigurable: Configurable {

    private var mySettingsComponent: ApplicationSettingsComponent? = null

    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getDisplayName(): String {
        return "SDK: Application Settings Example"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return mySettingsComponent?.getPreferredFocusedComponent()
    }

    override fun createComponent(): JComponent? {
        mySettingsComponent = ApplicationSettingsComponent()
        return mySettingsComponent?.getPanel()
    }

    override fun isModified(): Boolean {
        AppSettingsState.getInstance()?.run {
            var modified: Boolean = mySettingsComponent?.getUserNameText() != userId
            modified = modified or (mySettingsComponent?.getIdeaUserStatus() != ideaStatus)
            return modified
        }
        return false
    }

    override fun apply() {
        AppSettingsState.getInstance()?.run {
            userId = mySettingsComponent?.getUserNameText()
            ideaStatus = mySettingsComponent?.getIdeaUserStatus()
        }
    }

    override fun reset() {
        AppSettingsState.getInstance()?.run {
            mySettingsComponent?.setUserNameText(userId)
            ideaStatus?.let { status ->
                mySettingsComponent?.setIdeaUserStatus(status)
            }
        }
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }
}