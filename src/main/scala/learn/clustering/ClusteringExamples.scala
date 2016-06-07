package learn.clustering

import learn.clustering.models.{LDA, KMeans}


/**
 * Examples of how to instantiate different unsupervised models
 * */
object ClusteringExamples {

  // example of how to create a K Means model
  val kmeans: KMeans = Clustering.trainKMeansModel(Nil, k = 3)

  // example of how to create a K Means model with different number of iterations
  val kmeansWith50Iter: KMeans = Clustering.trainKMeansModel(Nil, k = 3, numIterations = 50)

  // example of how to create an LDA model
  val lda: LDA = Clustering.trainLDAModel(Nil, k = 3)

}
