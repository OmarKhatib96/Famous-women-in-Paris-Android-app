package com.ismin.opendataapp


data class Women(
    val datasetid: String,
    val fields: Fields,
    val geometry: Geometry,
    val record_timestamp: String,
    val recordid: String
)

data class Fields(
    val desc1: String,
    val desc2: String,
    val desc3: String,
    val desc4: String,
    val geo_point_2d: List<Double>,
    val geo_shape: GeoShape,
    val lat: Double,
    val long: Double,
    val name: String,
    val photos: Photos,
    val short_desc: String,
    val tab_name: String,
    val thumb_url: String
)

data class GeoShape(
    val coordinates: List<Double>,
    val type: String
)

data class Photos(
    val color_summary: List<String>,
    val filename: String,
    val format: String,
    val height: Int,
    val id: String,
    val mimetype: String,
    val thumbnail: Boolean,
    val width: Int
)

data class Geometry(
    val coordinates: List<Double>,
    val type: String
)
