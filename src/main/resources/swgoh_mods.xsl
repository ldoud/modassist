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

        <xsl:attribute name="type">
            <xsl:value-of select="@alt"/>
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

    <xsl:template match="span[@class = 'statmod-stat-value']">
        <xsl:attribute name="value">
            <xsl:value-of select="."/>
        </xsl:attribute>
    </xsl:template>

    <xsl:template match="span[@class = 'statmod-stat-label']">
        <xsl:attribute name="name">
            <xsl:value-of select="."/>
        </xsl:attribute>
    </xsl:template>
</xsl:stylesheet>