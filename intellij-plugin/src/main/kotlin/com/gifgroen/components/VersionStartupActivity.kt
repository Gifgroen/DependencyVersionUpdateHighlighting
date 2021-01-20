package com.gifgroen.components

import com.gifgroen.notification.MyNotification
import com.gifgroen.state.VersionState
import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

class VersionStartupActivity : StartupActivity {

    companion object {
        private const val pluginId = "com.gifgroen.gradleDependencyVersionUpdater"

        private const val title = "Plugin updated"
    }

    override fun runActivity(project: Project) {
        PluginId.getId(pluginId).let { id ->
            PluginManagerCore.getPlugin(id)?.run {
                val versionState: VersionState = VersionState.getInstance()
                if (versionState.isNewVersion(version)) {
                    versionState.currentVersion = version
                    doVersionUpdateActivity(versionState.currentVersion, project)
                }
            }
        }
    }

    private fun doVersionUpdateActivity(
        currentVersion: String,
        project: Project
    ) {
        val content = "Welcome to the new version: $currentVersion"
        MyNotification.show(project, title, content)
    }
}