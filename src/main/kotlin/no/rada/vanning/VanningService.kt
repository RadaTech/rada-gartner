package no.rada.vanning

import org.slf4j.LoggerFactory

class VanningService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    internal fun vannPlante(mengdeVann: Double) {
        if (mengdeVann < MINIMUM_MENGDE_VANN) throw Exception("Forsøker å vanne med for lite vann. Må være minimum $MINIMUM_MENGDE_VANN dl. Forespørsel = '$mengdeVann'")

        logger.info("Vanner plante med $mengdeVann dl")
    }

    companion object {
        const val MINIMUM_MENGDE_VANN = 0.01
    }
}