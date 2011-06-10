package net.liftweb.appendIdToMappedField.model

import net.liftweb.mapper._

class Guy extends LongKeyedMapper[Guy] with IdPK {
  def getSingleton = Guy

  object field1 extends MappedString(this, 100)

  object field2 extends MappedString(this, 100)

  object field3 extends MappedString(this, 100)

  object field4 extends MappedString(this, 100)

  object field5 extends MappedString(this, 100)

  object field6 extends MappedString(this, 100)

}

object Guy extends Guy with LongKeyedMetaMapper[Guy] {

}