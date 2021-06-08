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

Route::prefix('/')->group(function(){
    Route::post('/login', 'App\Http\Controllers\LoginController@index');
    Route::post('/register', 'App\Http\Controllers\LoginController@store');
});
