<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="text"/>

    <xsl:variable name="newline"><xsl:text>
</xsl:text></xsl:variable>

    <xsl:template match="/">
        <xsl:apply-templates select="*"/>
    </xsl:template>

    <xsl:template match="mods">
        <xsl:text>Character,Slot,Set,Level,Dots,Primary Stat,Primary Value,Speed,Offense,Offense Percent,Defense,Defense Percent,Potency,Protection,Protection Percent,Critical Chance,Health,Health Percent,Tenacity</xsl:text>
        <xsl:value-of select="$newline"/>
        <xsl:apply-templates select="*"/>
    </xsl:template>

    <xsl:template match="mod">
        <xsl:apply-templates select="@character"/>
        <xsl:apply-templates select="@slot"/>
        <xsl:apply-templates select="@set"/>
        <xsl:apply-templates select="@level"/>
        <xsl:apply-templates select="@dots"/>
        <xsl:apply-templates select="stat[@type='primary']"/>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Speed']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Offense']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Offense Percent']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Defense']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Defense Percent']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Potency']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Protection']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Protection Percent']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Critical Chance']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Health']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Health Percent']"/><xsl:text>,</xsl:text>
        <xsl:apply-templates select="stat[@type='secondary' and @name='Tenacity']"/>
        <xsl:value-of select="$newline"/>
    </xsl:template>

    <xsl:template match="stat[@type='primary']">
        <xsl:value-of select="@name"/>,<xsl:value-of select="@value"/><xsl:text>,</xsl:text>
    </xsl:template>

    <xsl:template match="stat[@type='secondary']">
        <xsl:value-of select="@value"/><xsl:text/>
    </xsl:template>

    <xsl:template match="@*"><xsl:value-of select="."/><xsl:text>,</xsl:text></xsl:template>
</xsl:stylesheet>