package learn.clustering.models

import org.apache.spark.mllib.util.Saveable
import scala.reflect.ClassTag
import learn._


abstract class ClusteringModel[A: ClassTag] {

  val model: Saveable

  def saveTo(outFile: String): Unit = model.save(sc, outFile)

  def loadFrom(modelFile: String): A

}