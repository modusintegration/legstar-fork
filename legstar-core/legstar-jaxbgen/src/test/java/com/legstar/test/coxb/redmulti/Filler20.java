
package com.legstar.test.coxb.redmulti;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for Filler20 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Filler20">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SeedHours">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;totalDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SeedMinutes">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;totalDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SeedSeconds">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;totalDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SeedHundredth">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;totalDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Filler20", propOrder = {
    "seedHours",
    "seedMinutes",
    "seedSeconds",
    "seedHundredth"
})
public class Filler20
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SeedHours")
    @CobolElement(cobolName = "SEED-HOURS", type = CobolType.ZONED_DECIMAL_ITEM, levelNumber = 5, isSigned = false, totalDigits = 2, picture = "99", srceLine = 21)
    protected int seedHours;
    @XmlElement(name = "SeedMinutes")
    @CobolElement(cobolName = "SEED-MINUTES", type = CobolType.ZONED_DECIMAL_ITEM, levelNumber = 5, isSigned = false, totalDigits = 2, picture = "99", srceLine = 22)
    protected int seedMinutes;
    @XmlElement(name = "SeedSeconds")
    @CobolElement(cobolName = "SEED-SECONDS", type = CobolType.ZONED_DECIMAL_ITEM, levelNumber = 5, isSigned = false, totalDigits = 2, picture = "99", srceLine = 23)
    protected int seedSeconds;
    @XmlElement(name = "SeedHundredth")
    @CobolElement(cobolName = "SEED-HUNDREDTH", type = CobolType.ZONED_DECIMAL_ITEM, levelNumber = 5, isSigned = false, totalDigits = 2, picture = "99", srceLine = 24)
    protected int seedHundredth;

    /**
     * Gets the value of the seedHours property.
     * 
     */
    public int getSeedHours() {
        return seedHours;
    }

    /**
     * Sets the value of the seedHours property.
     * 
     */
    public void setSeedHours(int value) {
        this.seedHours = value;
    }

    public boolean isSetSeedHours() {
        return true;
    }

    /**
     * Gets the value of the seedMinutes property.
     * 
     */
    public int getSeedMinutes() {
        return seedMinutes;
    }

    /**
     * Sets the value of the seedMinutes property.
     * 
     */
    public void setSeedMinutes(int value) {
        this.seedMinutes = value;
    }

    public boolean isSetSeedMinutes() {
        return true;
    }

    /**
     * Gets the value of the seedSeconds property.
     * 
     */
    public int getSeedSeconds() {
        return seedSeconds;
    }

    /**
     * Sets the value of the seedSeconds property.
     * 
     */
    public void setSeedSeconds(int value) {
        this.seedSeconds = value;
    }

    public boolean isSetSeedSeconds() {
        return true;
    }

    /**
     * Gets the value of the seedHundredth property.
     * 
     */
    public int getSeedHundredth() {
        return seedHundredth;
    }

    /**
     * Sets the value of the seedHundredth property.
     * 
     */
    public void setSeedHundredth(int value) {
        this.seedHundredth = value;
    }

    public boolean isSetSeedHundredth() {
        return true;
    }

}
