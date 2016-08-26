package org.openfact.actions;

import org.openfact.provider.Provider;

/**
 * RequiredAction provider.  Required actions are one-time actions that a user must perform before they are logged in.
 *
 */
public interface RequiredActionProvider extends Provider {
    /**
     * Called every time a uesr authenticates.  This checks to see if this required action should be triggered.
     * The implementation of this method is responsible for setting the required action on the UserModel.
     *
     * For example, the UpdatePassword required actions checks the password policies to see if the password has expired.
     *
     * @param context
     */
    void evaluateTriggers(RequiredActionContext context);

    /**
     * If the user has a required action set, this method will be the initial call to obtain what to display to the
     * user's browser.  Return null if no action should be done.
     *
     * @param context
     * @return
     */
    void requiredActionChallenge(RequiredActionContext context);

    /**
     * Called when a required action has form input you want to process.
     *
     * @param context
     */
    void processAction(RequiredActionContext context);
}
