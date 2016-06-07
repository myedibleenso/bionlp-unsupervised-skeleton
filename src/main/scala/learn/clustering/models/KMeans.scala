package learn.clustering.models

import org.apache.spark.mllib.clustering.{KMeans => KM, KMeansModel}
import edu.arizona.sista.processors.Document
import learn._


/** Storage class for KMeans model */
case class KMeans(model: KMeansModel) extends ClusteringModel[KMeans] {

  def loadFrom(modelFile: String): KMeans = KMeans.loadFrom(modelFile)

}

/** Companion object for  for KMeans */
object KMeans {

  def apply(docs: Seq[Document], k: Int): KMeans = apply(docs, k, 50)

  def apply(docs: Seq[Document], k: Int, numIterations: Int): KMeans = {
    val ds = mkRVFDataset(docs)
    val rdd = rvfDatasetToRDD(ds)

    KMeans(KM.train(rdd, k, numIterations))
  }

  def loadFrom(modelFile: String): KMeans = KMeans(KMeansModel.load(sc, modelFile))
}