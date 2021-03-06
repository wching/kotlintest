package com.sksamuel.kotlintest.tests.matchers

import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldNot
import io.kotlintest.matchers.uri.haveHost
import io.kotlintest.matchers.uri.havePort
import io.kotlintest.matchers.uri.haveScheme
import io.kotlintest.specs.WordSpec
import java.net.URI

class UriMatchersTest : WordSpec() {

  init {

    "haveScheme" should {
      "test that a URI has the specified scheme" {
        URI.create("https://hostname") should haveScheme("https")
        URI.create("ftp://hostname") shouldNot haveScheme("https")
      }
    }

    "havePort" should {
      "test that a URI has the specified port" {
        URI.create("https://hostname:90") should havePort(90)
        URI.create("https://hostname") should havePort(-1)
        URI.create("ftp://hostname:14") shouldNot havePort(80)
      }
    }

    "haveHost" should {
      "test that a URI has the specified host" {
        URI.create("https://hostname:90") should haveHost("hostname")
        URI.create("https://wewqe") should haveHost("wewqe")
        URI.create("ftp://hostname:14") shouldNot haveHost("qweqwe")
      }
    }
  }
}