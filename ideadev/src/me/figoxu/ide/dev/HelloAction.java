package me.figoxu.ide.dev;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.ui.Messages;

public class HelloAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Messages.showMessageDialog("Hello World!","Sample", Messages.getInformationIcon());
        HelloDialog helloDialog = new HelloDialog();
        helloDialog.pack();
        helloDialog.setVisible(true);
    }
}
