package com;

/**
 * interface which allows the main frame and in general the main method to comunicate between
 * each panel. for example when the main panel needs to change panel for the option of quiz
 */
public interface mainListener {
    void onPanelChange(String panelName);
}
