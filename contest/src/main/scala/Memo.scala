import scala.collection.mutable

def memoize[In, Out](f: In => Out): In => Out = new mutable.HashMap[In, Out]() {self =>
  override def apply(key: In) = self.synchronized(getOrElseUpdate(key, f(key)))
}