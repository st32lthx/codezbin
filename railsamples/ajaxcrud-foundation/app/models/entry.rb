class Entry < ActiveRecord::Base
  attr_accessible :name, :address, :phone, :email
  validates_presence_of :name, :phone, :email
end