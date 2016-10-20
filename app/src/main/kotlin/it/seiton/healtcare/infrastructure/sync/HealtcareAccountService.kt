/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.seiton.healtcare.infrastructure.sync

import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.accounts.NetworkErrorException
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.IBinder

import timber.log.Timber

class HealtcareAccountService : Service() {

    companion object {

        private val TAG = "HealtcareAccountService"
        val ACCOUNT_NAME = "HealtcarebAccount"

        fun getAccount(accountType: String): Account {
            // Note: Normally the account name is set to the user's identity (username or email
            // address). However, since we aren't actually using any user accounts, it makes more sense
            // to use a generic string in this case.
            //
            // This string should *not* be localized. If the user switches locale, we would not be
            // able to locate the old account, and may erroneously register multiple accounts.
            val accountName = ACCOUNT_NAME
            return Account(accountName, accountType)
        }
    }

    private var mAuthenticator: Authenticator? = null

    override fun onCreate() {
        Timber.tag(TAG).d("(AS)::onCreate()")
        mAuthenticator = Authenticator(this)
    }

    override fun onDestroy() {
        Timber.tag(TAG).d("(AS)::onDestroy()")
    }

    override fun onBind(intent: Intent): IBinder? {
        return mAuthenticator!!.iBinder
    }

    inner class Authenticator(context: Context) : AbstractAccountAuthenticator(context) {

        override fun editProperties(accountAuthenticatorResponse: AccountAuthenticatorResponse,
                                    s: String): Bundle {
            throw UnsupportedOperationException()
        }

        @Throws(NetworkErrorException::class)
        override fun addAccount(accountAuthenticatorResponse: AccountAuthenticatorResponse,
                                s: String, s2: String, strings: Array<String>, bundle: Bundle): Bundle? {
            return null
        }

        @Throws(NetworkErrorException::class)
        override fun confirmCredentials(accountAuthenticatorResponse: AccountAuthenticatorResponse,
                                        account: Account, bundle: Bundle): Bundle? {
            return null
        }

        @Throws(NetworkErrorException::class)
        override fun getAuthToken(accountAuthenticatorResponse: AccountAuthenticatorResponse,
                                  account: Account, s: String, bundle: Bundle): Bundle {
            throw UnsupportedOperationException()
        }

        override fun getAuthTokenLabel(s: String): String {
            throw UnsupportedOperationException()
        }

        @Throws(NetworkErrorException::class)
        override fun updateCredentials(accountAuthenticatorResponse: AccountAuthenticatorResponse,
                                       account: Account, s: String, bundle: Bundle): Bundle {
            throw UnsupportedOperationException()
        }

        @Throws(NetworkErrorException::class)
        override fun hasFeatures(accountAuthenticatorResponse: AccountAuthenticatorResponse,
                                 account: Account, strings: Array<String>): Bundle {
            throw UnsupportedOperationException()
        }
    }


}

