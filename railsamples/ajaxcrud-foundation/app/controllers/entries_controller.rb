class EntriesController < ApplicationController
  def index
    @entry = Entry.new
    @entries = Entry.all
    
    respond_to do |format|
      format.html
      format.js
    end
  end

  def show
    @entry = Entry.find(params[:id])

    respond_to do |format|
      format.html
      format.js
    end
  end

  def new
    @entry = Entry.new

    respond_to do |format|
      format.html
      format.js
    end
  end

  def edit
    @entry = Entry.find(params[:id])
    respond_to do |format|
      format.html 
      format.js
    end
  end

  def create
    @entry = Entry.new(params[:entry])

    respond_to do |format|
      if @entry.save
        format.html { redirect_to(@entry) }
        format.js
      else
        format.html { render :action => "new" }
      end
    end
  end

  def update
    @entry = Entry.find(params[:id])

    respond_to do |format|
      if @entry.update_attributes(params[:entry])
        format.html { redirect_to(@entry) }
        format.js
      else
        format.html { render :action => "edit" }
      end
    end
  end

  def destroy
    @entry = Entry.find(params[:id])
    @entry.destroy

    respond_to do |format|
      format.html { redirect_to(entries_url) }
      format.js
    end
  end
end