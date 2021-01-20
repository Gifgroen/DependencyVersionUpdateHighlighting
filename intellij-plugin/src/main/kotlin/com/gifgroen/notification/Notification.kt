package com.gifgroen.notification

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.Nullable

class MyNotification {

    companion object {
        private const val NotificationGroupId = "MyGroup"

        fun show(
            project: @Nullable Project?,
            title: String,
            content: String
        ) {
            NotificationGroupManager.getInstance()
                .getNotificationGroup(NotificationGroupId)
                .createNotification(title, content, NotificationType.INFORMATION)
                .notify(project)
        }
    }
}