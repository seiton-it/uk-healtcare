package it.seiton.healtcare.ui.main.hospitals

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.view.View
import it.seiton.healtcare.domain.HospitalEntityFake
import kotlinx.android.synthetic.main.custom_hospital_details.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*

/**
 * Created by lukasw44 on 24/10/2016.
 */
@RunWith(AndroidJUnit4::class)
class HospitalDetailsPanelTest {

    lateinit var fixture: HospitalDetailsPanel

    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getTargetContext()

        fixture = HospitalDetailsPanel(appContext)
    }

    @Test
    @Throws(Exception::class)
    fun showHospital_FullHospitalEntity_showAllDetails() {

        //given
        val listener = mock(OnHospitalInfoClickListener::class.java)

        val entity = HospitalEntityFake.getSimpleEntity(
                fullAddress = "Blending Mews 222",
                city = "Farnham",
                county = "SURREY",
                postcode = "GU12",
                phone = "123123",
                email = "test@gmail.com",
                website = "test.website.com",
                fax = "2313",
                sector = "NHS"
        )

        //when
        fixture.showHospital(entity)
        fixture.listener = listener

        //then
        assert(fixture.tvAddress.text == "Blending Mews 222")
        assert(fixture.tvCityAndCounty.text == "Farnham, SURREY")
        assert(fixture.tvPostcode.text == "GU12")
        assert(fixture.llAddressContainer.visibility == View.VISIBLE)
        fixture.llAddressContainer.performClick()
        verify(listener, times(1)).onAddressItemClick(entity)

        assert(fixture.llPhoneContainer.visibility == View.VISIBLE)
        assert(fixture.tvPhone.text == "123123")
        //TODO LW Check what fail and run onAddressItemClick
        //fixture.llPhoneContainer.performClick()
        //verify(listener, times(1)).onPhoneItemClick(entity)

        assert(fixture.llEmailContainer.visibility == View.VISIBLE)
        assert(fixture.tvEmail.text == "test@gmail.com")
        fixture.llEmailContainer.performClick()
        verify(listener, times(1)).onEmailItemClick(entity)

        assert(fixture.llWebsiteContainer.visibility == View.VISIBLE)
        assert(fixture.tvWebsite.text == "test.website.com")
        fixture.llWebsiteContainer.performClick()
        verify(listener, times(1)).onWebsiteItemClick(entity)

        assert(fixture.llFaxContainer.visibility == View.VISIBLE)
        assert(fixture.tvFax.text == "2313")

        assert(fixture.llSectorContainer.visibility == View.VISIBLE)
        assert(fixture.tvSector.text == "NHS")
    }

    @Test
    @Throws(Exception::class)
    fun showHospital_EmptyHospitalEntity_showAllDetails() {

        //given
        val listener = mock(OnHospitalInfoClickListener::class.java)

        val entity = HospitalEntityFake.getSimpleEntity(
                fullAddress = "",
                city = "",
                county = "",
                postcode = "",
                phone = "",
                email = "",
                website = "",
                fax = "",
                sector = ""
        )

        //when
        fixture.showHospital(entity)
        fixture.listener = listener

        //then
        assert(fixture.tvAddress.text == "")
        assert(fixture.tvCityAndCounty.text == "")
        assert(fixture.tvPostcode.text == "")
        assert(fixture.llAddressContainer.visibility == View.VISIBLE)

        assert(fixture.llPhoneContainer.visibility == View.GONE)
        assert(fixture.llEmailContainer.visibility == View.GONE)
        assert(fixture.llWebsiteContainer.visibility == View.GONE)
        assert(fixture.llFaxContainer.visibility == View.GONE)
        assert(fixture.llSectorContainer.visibility == View.GONE)
    }

}