package it.seiton.healtcare.application

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.filters.MediumTest
import android.support.test.rule.ServiceTestRule
import android.support.test.runner.AndroidJUnit4
import it.seiton.healtcare.infrastructure.sync.HealtcareSyncAdapterService
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeoutException

@MediumTest
@RunWith(AndroidJUnit4::class)
class LocalServiceTest {
    @Rule
    val mServiceRule = ServiceTestRule()

    @Test
    @Throws(TimeoutException::class)
    fun testWithBoundService() {
        // Create the service Intent.
        val serviceIntent = Intent(InstrumentationRegistry.getTargetContext(), HealtcareSyncAdapterService::class.java)

        // Data can be passed to the service via the Intent.

        // Bind the service and grab a reference to the binder.
        val binder = mServiceRule.bindService(serviceIntent)

        // Get the reference to the service, or you can call public methods on the binder directly.

        // Verify that the service is working correctly.
        val intent = Intent()


    }
}