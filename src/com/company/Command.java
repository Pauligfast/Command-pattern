package com.company;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * Created by Paulig on 4/26/2017.
 */
class Command {

    UndoManager manager = new UndoManager();

    Action Do = new RedoAction(manager);
    Action Undo = new UndoAction(manager);
    Decorator decorator;


    public void performUndo() {
        decorator = new Decorator(new UndoDecorator());
        decorator.count();
    }

    public void performRedo() {
        decorator = new Decorator(new RedoDecorator());
        decorator.count();
    }


    class UndoAction extends AbstractAction {
        public UndoAction(UndoManager manager) {
            this.manager = manager;
        }

        public void actionPerformed(ActionEvent evt) {
            try {
                manager.undo();
                performUndo();
            } catch (CannotUndoException e) {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        private UndoManager manager;
    }

    // The Redo action
    class RedoAction extends AbstractAction {
        public RedoAction(UndoManager manager) {
            this.manager = manager;
        }

        public void actionPerformed(ActionEvent evt) {
            try {
                manager.redo();
                performRedo();
            } catch (CannotRedoException e) {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        private UndoManager manager;
    }
}
