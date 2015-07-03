import org.apache.http.util.EntityUtils
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.config.RequestConfig
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager

object Boot extends App {
  val requestConfig = RequestConfig.custom()
    .setConnectTimeout(5)
    .setSocketTimeout(5)
    .build()

    val mgr = new PoolingHttpClientConnectionManager()
    mgr.setDefaultMaxPerRoute(100)
    mgr.setMaxTotal(100)

    val client = HttpClientBuilder.create()
      .setDefaultRequestConfig(requestConfig)
      .setConnectionManager(mgr)
      .build()


      (1 to 1000).foreach { i =>
        try {
        val res = client.execute(new HttpGet("http://10.4.17.210/hello"))
        val str = EntityUtils.toString(res.getEntity)

          println(s"$i=$str")
        }catch {
          case e => println(e)
        }
      }
}
