package geotrellis.admin.client.circuit

import diode._
import diode.data._
import diode.util._
import org.scalajs.dom.ext.Ajax
import scala.concurrent.ExecutionContext.Implicits.global

import geotrellis.admin.shared.LayerDescription

object Catalog {
  val currentLayerName: ModelR[RootModel, Option[String]] = AppCircuit.zoom(_.displayM.layer.map(_.name))
  val currentColorRamp: ModelR[RootModel, Option[String]] = AppCircuit.zoom(_.displayM.ramp)
  val currentBreaksCount: ModelR[RootModel, Option[Int]] = AppCircuit.zoom(_.displayM.breaksCount)
  val currentOpacity: ModelR[RootModel, Option[Int]] = AppCircuit.zoom(_.displayM.opacity)
  val currentZoomLevel: ModelR[RootModel, Option[Int]] = AppCircuit.zoom(_.displayM.leafletM.zoom)

  def list = Ajax.get("http://localhost:8080/gt/layers")
  def metadata(name: String, zoom: Int) = Ajax.get(s"http://localhost:8080/gt/metadata/${name}/${zoom}")
  def bounds(name: String, zoom: Int) = Ajax.get(s"http://localhost:8080/gt/bounds/${name}/${zoom}")
  def breaks(name: String, breaks: Int) = Ajax.get(s"http://localhost:8080/gt/breaks/${name}/${breaks}")
}