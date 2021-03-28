
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddIntegerResult" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addIntegerResult"
})
@XmlRootElement(name = "AddIntegerResponse")
public class AddIntegerResponse {

    @XmlElement(name = "AddIntegerResult")
    protected long addIntegerResult;

    /**
     * Gets the value of the addIntegerResult property.
     * 
     */
    public long getAddIntegerResult() {
        return addIntegerResult;
    }

    /**
     * Sets the value of the addIntegerResult property.
     * 
     */
    public void setAddIntegerResult(long value) {
        this.addIntegerResult = value;
    }

}
