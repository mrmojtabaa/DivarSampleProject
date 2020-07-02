package com.mojtabahd.divar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.mojtabahd.divar.entitiy.SearchResponse
import com.mojtabahd.divar.entitiy.Category
import com.mojtabahd.divar.entitiy.Json_schema
import com.mojtabahd.divar.entitiy.DivarSearchRequest
import kotlinx.android.synthetic.main.fragment_first.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        Timber.tag("LifeCycles");
        Timber.d("Activity Created");

        val service = createApiService()
        val request = service.search(DivarSearchRequest(Json_schema(Category("ROOT")), 0))

        request?.enqueue(object : Callback<SearchResponse?> {
            override fun onFailure(call: Call<SearchResponse?>, t: Throwable) {
                Timber.tag("onFailure").d(t)
                textview_first.text = t.toString()
            }

            override fun onResponse(
                call: Call<SearchResponse?>,
                response: Response<SearchResponse?>
            ) {
                Timber.tag("onResponse").d(response.toString())
                val sb = StringBuilder()
                requireNotNull(response.body())
                    .widget_list.forEach {
                        with(sb)
                        {
                            append("\n")
                            append(it.data.title)
                            append("\n")
                            append(it.data.normal_text)
                            append("\n")
                        }
                    }

                textview_first.text = sb.toString()
            }
        })


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun createApiService(): DivarApiService {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor { chain: Interceptor.Chain ->
            val divarSearchRequest: Request =
                chain.request().newBuilder().addHeader("parameter", "value").build()
            Timber.tag("request body ==> ").d(chain.request().body().toString())
            val response = chain.proceed(divarSearchRequest)
            Timber.tag("response body ==> ").d(response.body().toString())
            response
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.divar.ir/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()

        return retrofit.create(DivarApiService::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}