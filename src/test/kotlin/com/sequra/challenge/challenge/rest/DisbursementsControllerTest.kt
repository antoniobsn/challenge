package com.sequra.challenge.challenge.rest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class DisbursementsControllerTest {

    @LocalServerPort
    private val port = 0

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(Exception::class)
    fun `should return specific merchant for period '2022-07-18' and id 1`() {

        val initialDate = "2022-07-18"
        val finalDate = "2022-07-18"
        val merchantId = "1"

        assertThat(
            restTemplate!!.getForObject(
                "http://localhost:$port" +
                        "/disbursements" +
                        "?initialDate=$initialDate" +
                        "&finalDate=$finalDate" +
                        "&merchantId=$merchantId",
                String::class.java
            )
        ).contains("[" +
                "{\"amount\":351.79,\"merchantResponse\":{\"name\":\"Treutel, Schumm and Fadel\",\"email\":\"info@treutel-schumm-and-fadel.com\",\"cif\":\"B611111111\"}}")
    }

    @Test
    @Throws(Exception::class)
    fun `should return all merchants for period '2022-07-18'`() {

        val initialDate = "2022-07-18"
        val finalDate = "2022-07-18"

        assertThat(
            restTemplate!!.getForObject(
                "http://localhost:$port" +
                        "/disbursements" +
                        "?initialDate=$initialDate" +
                        "&finalDate=$finalDate",
                String::class.java
            )
        ).contains("[" +
                "{\"amount\":351.79,\"merchantResponse\":{\"name\":\"Treutel, Schumm and Fadel\",\"email\":\"info@treutel-schumm-and-fadel.com\",\"cif\":\"B611111111\"}}," +
                "{\"amount\":369.78,\"merchantResponse\":{\"name\":\"Windler and Sons\",\"email\":\"info@windler-and-sons.com\",\"cif\":\"B611111112\"}}]")
    }

    @Test
    @Throws(Exception::class)
    fun `should return empty for invalid period`() {

        val initialDate = "2021-07-18"
        val finalDate = "2021-07-18"

        assertThat(
            restTemplate!!.getForObject(
                "http://localhost:$port" +
                        "/disbursements" +
                        "?initialDate=$initialDate" +
                        "&finalDate=$finalDate",
                String::class.java
            )
        ).contains("[]")
    }
}

