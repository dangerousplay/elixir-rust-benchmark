import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class IOBoundSimulation extends Simulation {

  val httpConf = http
    .baseUrl("http://localhost:8080")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val plainText = scenario("Plain Text")
    .exec(http("Plain Text")
      .get("/plaintext")
    )

  val json = scenario("JSON")
    .exec(http("JSON")
      .get("/json")
    )

  setUp(
    plainText.inject(
      constantUsersPerSec(1000) during(60 seconds)
    ),
    /*json.inject(
      heavisideUsers(10000) during(20 seconds)
    )*/
  ).protocols(httpConf)
}