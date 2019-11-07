import scala.collection.mutable
object Memo {
  def memoize[InType, OutType](f: InType => OutType): InType => OutType = new mutable.HashMap[InType, OutType]() {
    self => override def apply(key: InType): OutType = self.synchronized(getOrElseUpdate(key, f(key)))
  }
}


