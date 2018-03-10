<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="test"/>

    <xsl:template match="/">
        <xsl:apply-templates select="*"/>
    </xsl:template>

    <xsl:template match="mods">
        <xsl:text>slot,set,level,dots,primary stat,primary value,speed,offense,defence,potency,protection,critical chance,health,tenacity
        </xsl:text>
        <xsl:apply-templates select="*"/>
    </xsl:template>

    <xsl:template match="mod">
        <xsl:value-of select="concat(@slot,','@set,','@level,','@dots,','@slot,',')"/>
    </xsl:template>
</xsl:stylesheet>