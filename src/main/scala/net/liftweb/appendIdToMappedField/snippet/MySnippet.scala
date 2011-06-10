package net.liftweb.appendIdToMappedField
package snippet

import scala.xml.Null
import scala.xml.MetaData
import net.liftweb.http.S
import scala.xml.Elem
import net.liftweb.appendIdToMappedField.model.Guy
import net.liftweb.http.RequestVar
import _root_.scala.xml.{ NodeSeq, Text }
import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.java.util.Date
import Helpers._

class MySnippet {
  object rvGuy extends RequestVar(Guy.create)

  def errorMsg(id: String) = <lift:Msg errorClass="error"></lift:Msg> % ("id" -> id)

  def getAttrs(xml: NodeSeq) =
    xml match {
      case e: Elem => e.attributes
      case other => Null
    }

  def createGuy =
    ".field1" #> ("label *" #> "First field:" & "input" #> rvGuy.is.field1.toForm) &
      ".field2" #> ("label *" #> "Second field:" & "input" #> (errorMsg(rvGuy.is.field2.uniqueFieldId.openOr("")) ++ rvGuy.is.field2.toForm)) &
      ".field3" #> ("label *" #> "Third field:" & "input" #> (errorMsg(rvGuy.is.field3.uniqueFieldId.openOr("")) ++ rvGuy.is.field3.toForm.map(_ % S.attrsToMetaData))) &
      ".field4" #> ("label *" #> "Fourth field:" & "input" #> ((xml: NodeSeq) => (errorMsg(rvGuy.is.field4.uniqueFieldId.openOr("")) ++ rvGuy.is.field4.toForm.map(_ % getAttrs(xml)))))

}


