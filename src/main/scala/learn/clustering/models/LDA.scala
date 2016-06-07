package learn.clustering.models

import edu.arizona.sista.processors.Document
import learn._
import org.apache.spark.mllib.clustering.{LDA => LDAM, DistributedLDAModel, LDAModel}


/** Storage class for LDA model */
case class LDA(model: LDAModel) extends ClusteringModel[LDA] {

  def loadFrom(modelFile: String): LDA = LDA.loadFrom(modelFile)
}

/** Companion object for LDA Model */
object LDA {

  def apply(docs: Seq[Document], k: Int): LDA = {
    val ds = mkRVFDataset(docs)
    val rdd = rvfDatasetToRDD(ds)
    // spark magic
    val corpus = rdd.zipWithIndex.map(_.swap).cache()
    val mdl = new LDAM().setK(k).run(corpus)

    new LDA(mdl)
  }

  def loadFrom(modelFile: String): LDA = LDA(DistributedLDAModel.load(sc, modelFile))
}