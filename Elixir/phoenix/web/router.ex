defmodule Hello.Router do
  use Hello.Web, :router

  scope "/", Hello do
    get "/json", PageController, :_json
    get "/plaintext", PageController, :plaintext
    get "/", PageController, :index
  end
end
