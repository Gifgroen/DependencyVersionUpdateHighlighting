package com.gifgroen.actions

import com.gifgroen.notification.MyNotification
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class MyAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        MyNotification.show(
            e.project,
            "My Action occurred",
            "My Action ocurred Content"
        )
    }
}