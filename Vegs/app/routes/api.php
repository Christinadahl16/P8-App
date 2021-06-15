<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});
use App\Http\Controllers\AuthController;

Route::middleware('auth:sanctum')->post('/farmer', 'App\Http\Controllers\FarmerController@store');
Route::middleware('auth:sanctum')->get('/farmers', 'App\Http\Controllers\FarmerController@index');
Route::middleware('auth:sanctum')->get('/farmer/{id}', 'App\Http\Controllers\FarmerController@show');
Route::middleware('auth:sanctum')->put('/farmer/{id}', 'App\Http\Controllers\FarmerController@update');
Route::middleware('auth:sanctum')->delete('/farmer/{id}', 'App\Http\Controllers\FarmerController@destroy');


Route::middleware('auth:sanctum')->post('/product', 'App\Http\Controllers\ProductController@store');
Route::middleware('auth:sanctum')->get('/products/{id}', 'App\Http\Controllers\ProductController@index');
Route::middleware('auth:sanctum')->get('/product/{id}', 'App\Http\Controllers\ProductController@show');
Route::middleware('auth:sanctum')->put('/product/{id}', 'App\Http\Controllers\ProductController@update');
Route::middleware('auth:sanctum')->get('/productsByID/{showByID}', 'App\Http\Controllers\ProductController@showByID');
Route::middleware('auth:sanctum')->delete('/product/{id}', 'App\Http\Controllers\ProductController@destroy');


Route::middleware('auth:sanctum')->post('/cart', 'App\Http\Controllers\CartController@store');
Route::middleware('auth:sanctum')->get('/cart', 'App\Http\Controllers\CartController@index');


Route::prefix('/')->group(function(){
    Route::post('/login', 'App\Http\Controllers\LoginController@index');
    Route::post('/register', 'App\Http\Controllers\LoginController@store');
});
