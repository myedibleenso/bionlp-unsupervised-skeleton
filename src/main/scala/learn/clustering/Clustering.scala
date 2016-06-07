package learn.clustering


import edu.arizona.sista.processors.Document
import learn.clustering.models.{KMeans, LDA}



/** Factory for training/loading clustering models */
object Clustering {

  def loadLDAModel(mf: String): LDA = LDA.loadFrom(mf)

  def trainLDAModel(docs: Seq[Document], k: Int): LDA = LDA(docs, k)

  def loadKMeansModel(mf: String): KMeans = KMeans.loadFrom(mf)

  def trainKMeansModel(docs: Seq[Document], k: Int): KMeans = KMeans(docs, k)
  def trainKMeansModel(
    docs: Seq[Document],
    k: Int,
    numIterations: Int
  ): KMeans = KMeans(docs, k, numIterations)

}