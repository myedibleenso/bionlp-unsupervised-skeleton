package learn.clustering

import edu.arizona.sista.learning.RVFDataset
import edu.arizona.sista.processors.Document
import org.apache.spark.mllib.linalg.{Vectors, Vector}
import org.apache.spark.rdd.RDD
import learn._


package object models {

  /**
   * doc -> features -> datum -> dataset
   */
  def mkRVFDataset(docs: Seq[Document]): RVFDataset[String, String]  = {

    val dataset = new RVFDataset[String, String]
    for (doc <- docs) {
      // extract features
      val datum = FeatureExtractor.mkRVFDatum(doc, "none")
      // append
      dataset += datum
    }
    dataset
  }

  /**
   * https://spark.apache.org/docs/0.6.0/scala-programming-guide.html
   * @param rvfds
   * @return an RDD
   */

  def rvfDatasetToRDD(rvfds: RVFDataset[_, _]): RDD[Vector] = {

    val rows = rvfds.values.map(row => Vectors.dense(row))

    sc.parallelize(rows)
  }

}
