<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
        <xsl:element name="mods">
            <xsl:apply-templates select="*"/>
        </xsl:element>
    </xsl:template>

    <xsl:template match="node()|@*">
        <xsl:apply-templates select="node()|@*"/>
    </xsl:template>

    <xsl:template match="div[@class = 'collection-mod']">
        <xsl:element name="mod">
            <xsl:apply-templates select="node()|@*"/>
        </xsl:element>
    </xsl:template>

    <xsl:template match="span[@class = 'statmod-level']">
        <xsl:attribute name="level">
            <xsl:value-of select="."/>
        </xsl:attribute>
    </xsl:template>

    <xsl:template match="img[@class = 'char-portrait-img']">
        <xsl:attribute name="character">
            <xsl:value-of select="@alt"/>
        </xsl:attribute>
    </xsl:template>

    <!-- TODO: Break the "set" and "type" appart -->
    <xsl:template match="img[@class = 'statmod-img']">
        <xsl:variable name="dotsAsRomanNumerial" select="substring-after(substring-before(@alt, '-'), ' ')"/>

        <xsl:attribute name="dots">
            <xsl:choose>
                <xsl:when test="$dotsAsRomanNumerial = 'I'">1</xsl:when>
                <xsl:when test="$dotsAsRomanNumerial = 'II'">2</xsl:when>
                <xsl:when test="$dotsAsRomanNumerial = 'III'">3</xsl:when>
                <xsl:when test="$dotsAsRomanNumerial = 'IV'">4</xsl:when>
                <xsl:when test="$dotsAsRomanNumerial = 'V'">5</xsl:when>
            </xsl:choose>
        </xsl:attribute>

        <xsl:call-template name="mod-set">
            <xsl:with-param name="mod-description" select="@alt"/>
        </xsl:call-template>

        <xsl:call-template name="mod-slot">
            <xsl:with-param name="mod-description" select="@alt"/>
        </xsl:call-template>

    </xsl:template>

    <xsl:template name="mod-set">
        <xsl:param name="mod-description"/>
        <xsl:attribute name="set">
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Health')">Health</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Defense')">Defense</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Crit Damage')">Crit Damage</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Crit Chance')">Crit Chance</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Tenacity')">Tenacity</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Offense')">Offense</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Potency')">Potency</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Speed')">Speed</xsl:when>
            </xsl:choose>
        </xsl:attribute>
    </xsl:template>

    <xsl:template name="mod-slot">
        <xsl:param name="mod-description"/>
        <xsl:attribute name="slot">
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Transmitter')">Transmitter</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Receiver')">Receiver</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Processor')">Processor</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Holo-Array')">Holo-Array</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Data-Bus')">Data-Bus</xsl:when>
            </xsl:choose>
            <xsl:choose>
                <xsl:when test="contains($mod-description, 'Multiplexer')">Multiplexer</xsl:when>
            </xsl:choose>
        </xsl:attribute>
    </xsl:template>

    <xsl:template match="div[@class = 'statmod-stats statmod-stats-1']">
        <xsl:apply-templates select="node()|@*">
            <xsl:with-param name="type">primary</xsl:with-param>
        </xsl:apply-templates>
    </xsl:template>

    <xsl:template match="div[@class = 'statmod-stats statmod-stats-2']">
        <xsl:apply-templates select="node()|@*">
            <xsl:with-param name="type">secondary</xsl:with-param>
        </xsl:apply-templates>
    </xsl:template>

    <xsl:template match="div[@class = 'statmod-stat']">
        <xsl:param name="type"/>

        <xsl:element name="stat">
            <xsl:attribute name="type"><xsl:value-of select="$type"/></xsl:attribute>
            <xsl:apply-templates select="node()|@*"/>
        </xsl:element>

    </xsl:template>

    <xsl:template match="span[@class = 'statmod-stat-label']">
        <xsl:variable name="statValue" select="../span[@class = 'statmod-stat-value']"/>

        <xsl:choose>
            <xsl:when test=". = 'Critical Chance' or . = 'Potency' or . = 'Tenacity' or . = 'Critical Damage' or . = 'Accuracy' or . =  'Critical Avoidance'">
                <xsl:attribute name="name">
                    <xsl:value-of select="."/>
                </xsl:attribute>
            </xsl:when>
            <xsl:when test="contains($statValue, '%')">
                <xsl:attribute name="name">
                    <xsl:value-of select="concat(., 'Percent')"/>
                </xsl:attribute>
            </xsl:when>
            <xsl:otherwise>
                <xsl:attribute name="name">
                    <xsl:value-of select="."/>
                </xsl:attribute>
            </xsl:otherwise>
        </xsl:choose>

    </xsl:template>

    <xsl:template match="span[@class = 'statmod-stat-value']">
        <xsl:choose>
            <!-- If there is a percent, remove the first and last characters. -->
            <xsl:when test="contains(., '%')">
                <xsl:attribute name="value">
                    <xsl:value-of select="substring(., 2, string-length(.)-2)"/>
                </xsl:attribute>
            </xsl:when>
            <!-- If there is not a percent, then just remove the first character. -->
            <xsl:otherwise>
                <xsl:attribute name="value">
                    <xsl:value-of select="substring(., 2)"/>
                </xsl:attribute>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

</xsl:stylesheet>