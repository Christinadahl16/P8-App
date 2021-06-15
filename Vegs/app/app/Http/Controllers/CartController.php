<?php

namespace App\Http\Controllers;
use App\Models\Sale;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\Auth;

class CartController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
         $items = Sale::orderByDesc('updated_at')->where("user_id", Auth::id())->get();


         return response($items);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate($request, [
            'products' => 'required'
        ]);



        $productJsonString =  $request["products"];


         $productJsonArray = json_decode($productJsonString, true);


         $idListString = "";
         foreach ($productJsonArray["product"] as $productJsonObject)
         {
               $post = new Sale;
               $post->delivery = $productJsonArray["delivery"];
               $post->quantity= $productJsonObject["qty"];
               $post->user_id = Auth::id();
               $post->product_id = $productJsonObject["id"];
               $post->amount = $productJsonObject["price"];
               $post->save();
               if ($idListString != "")
                    $idListString .= ",";

               $idListString .=$post->id;
         }

         return $this->showByID($idListString);
    }

    public function showByID($idListString)
    {
        $idList = explode(",", $idListString);

        $items = Sale::whereIn('id', $idList)->orderByDesc('updated_at')->get();
        return response($items);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {

    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {

    }



    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {

    }
}
